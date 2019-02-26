# Version-Control-System
This is the implementation of a versioning system, that supports a set of UNIX commands like: create, modify, delete files, as well as a VCS command set, which will allow saving the current state of the file system.
The purpose of this project is to make it possible to return to previous versions of the file system.

File system commands:
1. cd
2. mkdir
3. ls
4. touch
5. rm
6. writetofile
7. cat
8. print

VCS commands:
1. status
2. branch
3. commit
4. checkout
5. log
6. rollback

Another requirement was to identify any possible errors in the syntax, logical succession of commands etc., and to return appropriate error messages like : 
Vcs: Bad command
Vcs: Bad path
Vcs: There are staged operations, please do commit/rollback!
System: Bad command
System: Bad path
