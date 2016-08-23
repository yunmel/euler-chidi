echo on
echo "################ copy db script ################"
set euler_home=D:\git_euler
set dest_path=%cd%\src\main\resources\db_script
echo %dest_path%

set euler_sem_script=%euler_home%\euler-sem\euler-sem-service\dbsql
set euler_ci_script=%euler_home%\euler-ci\euler-ci-service\sql
set euler_iam_script=%euler_home%\euler-iam\euler-iam-service\sql
set euler_mkt_script=%euler_home%\euler-mkt\euler-mkt-service\sql
set euler_pm_script=%euler_home%\euler-pm\euler-pm-service\sql
set euler_scm_script=%euler_home%\euler-scm\euler-scm-service\sql
set euler_spm_script=%euler_home%\euler-spm\euler-spm-service\sql
set euler_srm_script=%euler_home%\euler-srm\euler-srm-service\sql
set euler_tm_script=%euler_home%\euler-tm\euler-tm-service\sql
set euler_vcs_script=%euler_home%\euler-vcs\euler-vcs-service\sql
set euler_umc_script=%euler_home%\euler-umc\euler-umc-service\sql

for %%n in (
%euler_sem_script%,
%euler_ci_script%,
%euler_iam_script%,
%euler_mkt_script%,
%euler_pm_script%,
%euler_scm_script%,
%euler_spm_script%,
%euler_srm_script%,
%euler_tm_script%,
%euler_vcs_script%,
%euler_umc_script%
) do xcopy /Y /S %%n\* %dest_path%

cd %euler_home%
echo "################ copy db script completed ################"
pause