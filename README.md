# Nginx Config Generation and Letsencrypt

This can be used to dynamically create a nginx config while using only environment parameters or 
changing the CMD command to run the generation jar directly. When running the jar directly 
remember that entrypoint.sh must be run afterwards.


The dockerfile runs a the jar with the following parameters:


## Parameters
| Tables        | Are           | Cool                                | Example             |
| ------------- |:-------------:| -----------------------------------:| -----------------:  |
| --domainPrefix| -dp           |  the name of the domains prefix e.g. |'demo'               | 
| --domains      | -d            |  the name of the domains             |'freightpilot.eu'    |          
| --routes      | -r            |    $1                               |'maint'              |


## Usage Example

nginxgen --domainPrefix demo datel --domains freightpilot.eu freightpilot.de -domains 