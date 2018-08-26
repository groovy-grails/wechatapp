package weichatapp

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class SysUserSysRole implements Serializable {

	private static final long serialVersionUID = 1

	SysUser sysUser
	SysRole sysRole

	SysUserSysRole(SysUser u, SysRole r) {
		this()
		sysUser = u
		sysRole = r
	}

	@Override
	boolean equals(other) {
		if (!(other instanceof SysUserSysRole)) {
			return false
		}

		other.sysUser?.id == sysUser?.id && other.sysRole?.id == sysRole?.id
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (sysUser) builder.append(sysUser.id)
		if (sysRole) builder.append(sysRole.id)
		builder.toHashCode()
	}

	static SysUserSysRole get(long sysUserId, long sysRoleId) {
		criteriaFor(sysUserId, sysRoleId).get()
	}

	static boolean exists(long sysUserId, long sysRoleId) {
		criteriaFor(sysUserId, sysRoleId).count()
	}

	private static DetachedCriteria criteriaFor(long sysUserId, long sysRoleId) {
		SysUserSysRole.where {
			sysUser == SysUser.load(sysUserId) &&
			sysRole == SysRole.load(sysRoleId)
		}
	}

	static SysUserSysRole create(SysUser sysUser, SysRole sysRole, boolean flush = false) {
		def instance = new SysUserSysRole(sysUser: sysUser, sysRole: sysRole)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(SysUser u, SysRole r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = SysUserSysRole.where { sysUser == u && sysRole == r }.deleteAll()

		if (flush) { SysUserSysRole.withSession { it.flush() } }

		rowCount
	}

	static void removeAll(SysUser u, boolean flush = false) {
		if (u == null) return

		SysUserSysRole.where { sysUser == u }.deleteAll()

		if (flush) { SysUserSysRole.withSession { it.flush() } }
	}

	static void removeAll(SysRole r, boolean flush = false) {
		if (r == null) return

		SysUserSysRole.where { sysRole == r }.deleteAll()

		if (flush) { SysUserSysRole.withSession { it.flush() } }
	}

	static constraints = {
		sysRole validator: { SysRole r, SysUserSysRole ur ->
			if (ur.sysUser == null || ur.sysUser.id == null) return
			boolean existing = false
			SysUserSysRole.withNewSession {
				existing = SysUserSysRole.exists(ur.sysUser.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['sysUser', 'sysRole']
		version false
	}
}
