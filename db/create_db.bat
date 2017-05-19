@echo off

pushd %~dp0

echo Creating USERS...
sqlite3 TrainingApp.db ".read sql/USERS.sql"
echo Creating user_images...
sqlite3 TrainingApp.db ".read sql/user_images.sql"
echo Creating hobbies...
sqlite3 TrainingApp.db ".read sql/hobbies.sql"
echo Creating user_hobbies...
sqlite3 TrainingApp.db ".read sql/user_hobbies.sql"

popd

pause