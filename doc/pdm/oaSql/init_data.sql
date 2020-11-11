-- 插入交易
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaSignin', '打卡');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaSigninInfoListQry','打卡信息列表查询');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaSigninLater','补卡申请');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaSigninTimesStatisticsQry','打卡次数统计查询');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaLeaveApply','请假申请');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaBusinessApply','外出申请');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaPaymentApply','报销申请');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaAuthListQry','审批列表查询');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('menuQry','菜单查询');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaAuth','审核');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaApplyDetailQry','审核详情查询');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaUploadFile','文件上传');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaDownloadFile','文件下载');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaDeleteFile','文件删除');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaShowFilePath','文件路径展示');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaNewFilePath','新建文件夹');
INSERT INTO `oa_db`.`admin_permission`(`PERMISSION_ID`, `NAME`) VALUES ('oaRenameFilePath','重命名文件夹');

-- 插入菜单
INSERT INTO `oa_db`.`admin_menu`(`MENU_ID`, `NAME`, `PARENT_ID`) VALUES ('signin', '打卡', '0');
INSERT INTO `oa_db`.`admin_menu`(`MENU_ID`, `NAME`, `PARENT_ID`) VALUES ('leave', '请假申请', '0');
INSERT INTO `oa_db`.`admin_menu`(`MENU_ID`, `NAME`, `PARENT_ID`) VALUES ('business', '外出申请', '0');
INSERT INTO `oa_db`.`admin_menu`(`MENU_ID`, `NAME`, `PARENT_ID`) VALUES ('payment', '报销申请', '0');
INSERT INTO `oa_db`.`admin_menu`(`MENU_ID`, `NAME`, `PARENT_ID`) VALUES ('auth', '审核', '0');

-- 插入角色
INSERT INTO `oa_db`.`admin_role`(`ROLE_ID`, `NAME`, `ENABLED`) VALUES ('applyUser', '申请员', 1);
INSERT INTO `oa_db`.`admin_role`(`ROLE_ID`, `NAME`, `ENABLED`) VALUES ('authUser', '审核员', 1);

-- 角色菜单关联
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('applyUser', 'business');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('applyUser', 'leave');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('applyUser', 'payment');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('applyUser', 'signin');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('authUser', 'auth');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('authUser', 'business');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('authUser', 'leave');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('authUser', 'payment');
INSERT INTO `oa_db`.`admin_role_menu`(`ROLE_ID`, `MENU_ID`) VALUES ('authUser', 'signin');

-- 角色交易关联
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaSignin');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaSigninInfoListQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaSigninLater');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaSigninTimesStatisticsQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaLeaveApply');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaBusinessApply');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaPaymentApply');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaAuthListQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'menuQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaApplyDetailQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaUploadFile');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaDownloadFile');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('applyUser', 'oaShowFilePath');

INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaSignin');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaSigninInfoListQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaSigninLater');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaSigninTimesStatisticsQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaLeaveApply');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaBusinessApply');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaPaymentApply');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaAuthListQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'menuQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaAuth');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaApplyDetailQry');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaUploadFile');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaDownloadFile');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaDeleteFile');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaShowFilePath');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaNewFilePath');
INSERT INTO `oa_db`.`admin_role_permission`(`ROLE_ID`, `PERMISSION_ID`) VALUES ('authUser', 'oaRenameFilePath');

-- 打卡配置
-- 北航西部国际创新港
INSERT INTO `oa_db`.`oa_signin_config`(`DEPT_ID`, `LONGITUDE`, `LATITUDE`, `SIGNIN_RANGE`, `ON_TIME`, `OFF_TIME`) VALUES (0, '104.0812', '30.402149', 2000, '09:00', '18:00');
-- tlc
INSERT INTO `oa_db`.`oa_signin_config`(`DEPT_ID`, `LONGITUDE`, `LATITUDE`, `SIGNIN_RANGE`, `ON_TIME`, `OFF_TIME`) VALUES (1, '106.55073', '29.56471', 2000, '09:00', '18:00');
-- 人南
INSERT INTO `oa_db`.`oa_signin_config`(`DEPT_ID`, `LONGITUDE`, `LATITUDE`, `SIGNIN_RANGE`, `ON_TIME`, `OFF_TIME`) VALUES (2, '104.074173', '30.64178', 2000, '09:00', '18:00');

-- user初始化 测试数据
-- INSERT INTO `oa_db`.`oa_user`(`USER_ID`, `OPEN_ID`, `USERNAME`, `PASSWORD`, `PHONE`, `EMAIL`, `ROLE_ID`, `RANK_ID`) VALUES (7, 'abcd', 'xy', '202cb962ac59075b964b07152d234b70', '123', '123', 'authUser', 1);
-- INSERT INTO `oa_db`.`oa_user`(`USER_ID`, `OPEN_ID`, `USERNAME`, `PASSWORD`, `PHONE`, `EMAIL`, `ROLE_ID`, `RANK_ID`) VALUES (2, 'bcn', 'xjl', '202cb962ac59075b964b07152d234b70', '123', '123', 'applyUser', 2);
-- INSERT INTO `oa_db`.`oa_user`(`USER_ID`, `OPEN_ID`, `USERNAME`, `PASSWORD`, `PHONE`, `EMAIL`, `ROLE_ID`, `RANK_ID`) VALUES (1, 'o_EAe5PfnoHJb3cNL9kw2tcXqvSs', '唐鑫明', '202cb962ac59075b964b07152d234b70', NULL, NULL, 'authUser', 1);

-- holiday workday 初始化
insert into `oa_db`.`oa_workday`(`WORK_NAME`, `WORK_DATE`) values ('国庆节', '2020-09-27');
insert into `oa_db`.`oa_workday`(`WORK_NAME`, `WORK_DATE`) values ('国庆节', '2020-10-10');

insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-01');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-02');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-03');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-04');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-05');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-06');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-07');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('国庆节', '2020-10-08');
insert into `oa_db`.`oa_holiday`(`HOLIDAY_NAME`, `HOLIDAY_DATE`) values ('元旦', '2021-01-01');