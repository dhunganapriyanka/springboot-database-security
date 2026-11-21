#!/usr/bin/env bash
set -euo pipefail

# Create temporary credentials for this run.
export APP_USERNAME="${APP_USERNAME:-student}"
export APP_PASSWORD="${APP_PASSWORD:-$(openssl rand -hex 10)}"
export KEYSTORE_PASSWORD="${KEYSTORE_PASSWORD:-$(openssl rand -hex 12)}"

# Generate a local HTTPS certificate.
rm -f src/main/resources/keystore.p12
keytool -genkeypair \
  -alias springboot \
  -keyalg RSA -keysize 2048 \
  -storetype PKCS12 \
  -keystore src/main/resources/keystore.p12 \
  -storepass "$KEYSTORE_PASSWORD" \
  -keypass "$KEYSTORE_PASSWORD" \
  -validity 365 \
  -dname "CN=localhost, OU=Demo, O=Example, L=Local, ST=Local, C=US" \
  -ext "SAN=dns:localhost,ip:127.0.0.1" \
  -noprompt >/dev/null 2>&1

printf '\nHTTPS URL: https://localhost:8443/employees\n'
printf 'Username: %s\n' "$APP_USERNAME"
printf 'Password: %s\n' "$APP_PASSWORD"
printf 'Keep this password private.\n\n'

mvn spring-boot:run
