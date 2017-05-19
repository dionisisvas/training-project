@echo off

pushd %~dp0

echo Creating users...
sqlite3 TrainingApp.db ".read sql/users.sql"
echo Creating user_images...
sqlite3 TrainingApp.db ".read sql/user_images.sql"
echo Creating hobbies...
sqlite3 TrainingApp.db ".read sql/hobbies.sql"
echo Creating user_hobbies...
sqlite3 TrainingApp.db ".read sql/user_hobbies.sql"

popd

pause