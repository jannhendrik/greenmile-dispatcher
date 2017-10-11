Note: Naming must be changed. This started of as haproxy but now is nginx reverse proxy.


# Usage:

## Set up haproxy and webapp

Important! Do not expose any ports in production!!!

```
gr-landing-page:
  autoredeploy: true
  image: 'jannhendrik/gr-landing-page:latest'
  ports:
    - '3000'
  restart: always
  tags:
    - devcluster
haproxy-dev:
  image: 'dockercloud/haproxy:latest'
  links:
    - gr-landing-page
  ports:
    - '80:80'
    - '443:443'
  restart: always
  tags:
    - devcluster
```

## Set up haproxy-ssl

All Traffic goes through this nginx reverse proxy then to haproxy and finally to the web instance. Load Balancing can be done in haproxy.

```
haproxy-ssl-dev:
  image: 'jannhendrik/haproxy-ssl:latest'
  links:
    - haproxy-dev
  ports:
    - '80:80'
    - '443:443'
  restart: always
```

## Schema

() <- VPC only links within no exposed ports!!!

---HTTPS--->NGINX-REVERSE-PROXY(---HTTP--->HAPROXY---HTTP--->WEBAPP---HTTP--->BACkEND)


## Certificat Generation

The certificate is generated using certbot certonly. This service needs to be redeployed at least all 90 days. Free Letsecrypt certificate is used with a lease of 90 days.