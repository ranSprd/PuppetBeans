# Puppetbeans

__This release is in alpha state and not stable yet__

PuppetBeans brings support for Puppet to Netbeans (>8.0). It is inspired by
[tropyx/NetBeansPuppet](https://github.com/tropyx/NetBeansPuppet, "NetBeansPuppet on GitHub")

The main focus of PuppetBeans are Puppet script files, core features are:

 - syntax highlighting, 
 - file editor support (comments, occurrences)

## Installation
Currently binary packages are not available. Please read Development section for compiling 
a binary yourself with the latest development code. Then Install the plugin with: 
> Tools -> Plugins -> Download

## Requirements
NetBeans >= 8.0

## Development infos
First clone the repository:

    git clone https://github.com/ranSprd/PuppetBeans.git

and switch to the project folder

    cd PuppetBeans

This project is maven based. To build it just type:

    mvn clean install

after that you can find the plugin in `target/` folder as `PuppetBeans-VERSION.nbm`

## How to report bugs
If you find any bug or defect, report it [here](https://github.com/ranSprd/PuppetBeans/issues).


