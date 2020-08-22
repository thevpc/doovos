# doovos
Distributed Object Oriented Virtual Operating System


Doovos is a new Open Source Distributed Object Oriented Operating System Design and implementation based on the Java Plateform.
Actually, it is a try for designing a distributed operation system in top of existing centralized/network OS.
Designed OS will follow the object oriented architecture for redefining all OS resources (memory,process,file system,device,...etc.) in a highly distributed context.
For academic purpuses, design will try to propose the most configurable OS implementation allowing the test/validation and comparaison of some distributed OS algorithms
Doovos defines three important actors:
```
Site
System
Resource
```
The site is the Exported Object that represents a local instance of Doovos on a particular Machine.
Doovos as a distributed system, is the association of all of theses sites. On a single Physical machine many sites may be created.

The system is How all of theses sites are seen by every System or User Object (mainly what w'ill call Resource)

The Resource is any item that is handled by the distributed system. It may be a device or any soft resource such as file, process, folder, stream etc.

When launching multiple system instances (multiple sites), on any of these instances, user could/should see/use all the sites resources regardles on their location. All System resources, when it has a sens, may migrate from a site to another in a transparent way : user should not be alarmed for that.

Doovos provides a unique root (a la UNIX of course but not so much). this root has the following structure :
```
/--
  + device
  + process
  + file
  + stream
```

*device* folder is a holder for all devices supported by the system. actually only screen devices are supported. On every site, a default screen will be created. each screen may handle a set terminals (text terminal)

*process* folder is a holder for all processes created by the system regardless of their creation/execution location. every process uses a couple of memory (volatile) type of objects stored in two virtual folders names mem and env.
mem folder holds all process memory allocated objects for that process.
env is a holder for all env variables.

*file* folder is a holder for all sites exported folders. in fact every site (Doovos instance) can on boot time mount native folders (let's say C:/myexample) as virtual folder with a user defined name (let's say folder1 that will be accessible as /file/folder1); when different sites mount folders with the same virtual name, automatic fusion of both structures is processed by Doovos : Folders with the same name will be seen once and will hold all children for all folders with that particular name.

*stream* folder is a holder for streams sutch as file input and output streams, named pipes, ...etc.

Better documentation will of course be provided. For now you could type 'man' on the provided shell to get a list of useful commands.
the most useful is

```
tree
```
with show all the system objects structure.

## Main Features
Object Oriented
Based on the Java Plateform so may be used on top of all compatible native OS
Tiny kernel with Highly customizable components
Academic driven philosophy
Extensible architeture
Enhanced Shell
Load Balancing
Process, Memory and File Migration
... And any other useful feature you'll suggest ;)
