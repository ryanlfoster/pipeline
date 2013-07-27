Pipeline
========

A Continuous Delivery (CD) tool, which we and all stakeholders of the CD pipeline love to use. Licensed under the [MIT License][0]

> free, open-source  
> Continuous Delivery tool  
> that's simple to use for hobbyists,  
> flexible enough for startups  
> and powerful enough for the enterprise

Read [Why a new CD tool][1] for the reason and focus points behind this CD tool. And [DSL Design][2] to give you an intro into the Domain Specific Languange (DSL) that is used to define the pipeline and configure the jobs.

> Making the Impossible Possible  
> the Possible Simple  
> the Simple automated Away  

State of the project
--------------------
This project is currently in a very early state of development. Being developed in my free-time and every friday at work, the friday being sponsored by my employer [Tricode](http://www.tricode.nl)

Building Pipeline
--------------
The only prerequisite is that you have JDK 7 or higher installed.

After cloning the project, type `./gradlew clean build` (Windows: `gradlew clean build`). All build dependencies,
including [Gradle](http://www.gradle.org) itself, will be downloaded automatically (unless already present).

Resources
---------
* Pipeline Homepage -- http://pipelinelabs.org
* GitHub Organization -- http://github.pipelinelabs.org
* Documentation -- http://docs.pipelinelabs.org
* User/Dev Forum -- [http://forum.pipelinelabs.org][3]
* Issue Tracker -- http://issues.pipelinelabs.org

If you have any ideas, comments or questions, please direct them to the [user/dev forum][3].
All feedback is appreciated!


[0]: LICENSE
[1]: docs/Why-a-new-CD-tool.md
[2]: docs/DSL-design.md
[3]: http://forum.pipelinelabs.org
