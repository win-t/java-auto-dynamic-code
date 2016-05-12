# Dynamic load jar file
I create this project to show that java program can load some of their code without restart

## Scenario

1. Compile main program, `./src/main/build.bash`
2. Run main program, `java -jar HelloWorld.jar`
3. You will see some error, this is because file `lala.jar` is not exists yet
4. Open another terminal, and compile lala, `./src/lala/build.bash`
5. In first terminal you will see that `HelloImpl` is loaded, and the error is gone
6. Try to edit `HelloImpl.java`, for example change the version variable to v2, `sed -i 's/version = "v1"/version = "v2"/g' ./src/lala/HelloImpl.java`
7. Go to second terminal, and recompile lala, `./src/lala/build.bash`
8. In first terminal you will see the changes, that is, you do not need to restart to reload the code
