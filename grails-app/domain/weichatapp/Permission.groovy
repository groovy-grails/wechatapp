package weichatapp

class Permission {

   SysUser user
   String permission
   static constraints = {
      permission unique: 'user'
   }
}
