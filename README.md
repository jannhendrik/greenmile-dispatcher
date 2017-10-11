# Nginx Config Generation and Letsencrypt

This can be used to dynamically create a nginx config while using only environment parameters or 
changing the CMD command to run the generation jar directly. When running the jar directly 
remember that entrypoint.sh must be run afterwards.


The dockerfile runs a the jar with the following parameters:


## Parameters
| Tables        | Are           | Cool                                | Example             |
| ------------- |:-------------:| -----------------------------------:| -----------------:  |
| --domainPrefix| -dp           |  the name of the domain prefix e.g. |'demo'               | 
| --domain      | -d            |  the name of the domain             |'freightpilot.eu'    |          
| --routes      | -r            |    $1                               |'maint'              |


## Usage Example

nginxgen --domainPrefix demo datel --domain freightpilot.eu freightpilot.de -domain 