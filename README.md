# Online calculator automation solution

![Project Image](https://media-exp1.licdn.com/dms/image/D4D35AQFlDUkTx-OTxw/profile-framedphoto-shrink_200_200/0/1655459200064?e=1659337200&v=beta&t=Ysk-oT0JVkC9aoTYZr23s9aFlV5ZUsX4x0tGio5w08w)

> Test automation solution

---
### Table of Contents


- [Description](#description)
- [Installing docker images](#Images installation)
- [Running automation pack](#How to run the automation pack)
- [License](#license)
- [Author Info](#author-info)
---

## Description
automation assignment to simulate the behaviour of a user which interacts with the online calculator
#### Technologies

- Java 11
- selenium
- Cucumber
- springboot maven frame work (POM)
- git

[Back To The Top](#Online calculator automation solution)



## How To Use

## Images Installation
### Pull docker-selenium

     docker pull elgalu/selenium
### Pull Zalenium
    docker pull dosel/zalenium
    
    # Run it!
    sudo docker run --rm -ti --name zalenium -p 4444:4444 \
      -v /var/run/docker.sock:/var/run/docker.sock \
      -v /tmp/videos:/home/seluser/videos \
      --privileged dosel/zalenium start --desiredContainers 1

#### How to run the automation pack
- selenium grid /zalenium docker image must be running (!)
- virtual machine must be on (!)

       $~> rm -rf automationworkspace
       $~> mkdir automationworkspace
       $~> cd automationworkspace
       $~> git clone https://github.com/mohotsi/Selenium-automation-covenant.git
       $~> cd Selenium-automation-covenant

#### run automation remote
       $~> mvn clean test -Dbrowser=chrome -Dspring.profiles.active=remote
#### run it locally
       $-> mvn clean test
## License

Copyright (c) [2022] [Thapelo]
For helping me get vacancies

[Back To The Top](#read-me-template)

---

## Author Info

- linkedin - [Thapelo Daniel Mohotsi](https://www.linkedin.com/in/thapelo-daniel-mohotsi-1b752a42/)
- github - [Thapelo Daniel Mohotsi](https://github.com/mohotsi)

[Back To The Top](#read-me-template)



