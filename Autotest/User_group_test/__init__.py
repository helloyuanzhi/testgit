# coding=utf-8

import test7_finduser
import test6_finduserstatus
import test1_addusergroup
import test2_deleteusergroup
import test3_updateusergroup
import test4_findbyid
import test5_findallgroup

if __name__ == '__main__':

    test1_addusergroup.add_user_group()
    test2_deleteusergroup.delete_user_group()
    test3_updateusergroup.update_user_group()
    test4_findbyid.find_user_group()
    test5_findallgroup.find_all_group()
    test6_finduserstatus.find_user_status()
    test7_finduser.find_user()