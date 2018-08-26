import weichatapp.*
class BootStrap {

    def init = { servletContext ->
		//sunjh add at 20180825
		def sysUserList=SysUser.findAll()
		if(sysUserList.size()==0){
			def adminRole = new SysRole('ROLE_ADMIN').save()
			def userRole = new SysRole('ROLE_USER').save()
			def admin = new SysUser('admin', 'h2d9m0d1').save()
			def user = new SysUser('user', '271828').save()
			SysUserSysRole.create admin, adminRole, true
			SysUserSysRole.create user, userRole, true
			def p1=new Permission(user:admin,permission:'*:*').save()
			def p2=new Permission(user:user,permission:'queryAndStatistic:querySelfData').save()
		}
    }
    def destroy = {
    }
}
