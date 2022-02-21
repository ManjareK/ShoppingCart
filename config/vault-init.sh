#!/bin/sh

VAULT_DEV_TOKEN=spycjAioSYaD3YKZ37ipsvuRx

vault login ${VAULT_DEV_TOKEN}

vault secrets disable secret
vault secrets enable -version=1 -path=secret kv
vault kv put secret/catalog-service/docker @${CONFIG_DIR}/catalog-service.json
vault kv put secret/application/docker @${CONFIG_DIR}/application.json
vault kv put secret/inventory-service/docker @${CONFIG_DIR}/application.json
vault kv put secret/catalog-service @${CONFIG_DIR}/catalog-service.json
vault kv put secret/application @${CONFIG_DIR}/application.json


