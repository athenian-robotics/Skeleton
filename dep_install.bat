REM DON'T BLAME ME IF THIS BREAKS I DONT HAVE A MACHINE TO TEST WITH, THIS SHOULD WORJ
set DIRNAME=%~dp0
call git clone https://github.com/wpilibsuite/GradleRIO.git
set USEDIR="%DIRNAME%\GradleRIO\examples\java"
xcopy /s/e "%USEDIR%\gradle" "%DIRNAME%\gradle"
xcopy /s "%USEDIR\gradlew" "%DIRNAME%\gradlew"
del /F /Q GradleRIO
gradlew

