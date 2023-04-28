#!/bin/bash

application=$1
if [[ $application == '' ]]; then
  echo "using jhlite by default"
  application='jhlite'
fi

sonar=$(curl -sX GET 'http://localhost:9001/api/measures/component?component='"$application"'&metricKeys=bugs%2Ccoverage%2Cvulnerabilities%2Cduplicated_lines_density%2Ccode_smells%2Csecurity_hotspots');

echo "$sonar"|jq -r .component|jq -r .measures|jq '[.[]|select(.metric=="vulnerabilities")][0]'

vul=$(echo "$sonar"|jq -r .component|jq -r .measures|jq '[.[]|select(.metric=="vulnerabilities")][0]'|jq -r .value);
cov=$(echo "$sonar"|jq -r .component|jq -r .measures|jq '[.[]|select(.metric=="coverage")][0]'|jq -r .value);
bug=$(echo "$sonar"|jq -r .component|jq -r .measures|jq '[.[]|select(.metric=="bugs")][0]'|jq -r .value);
dup=$(echo "$sonar"|jq -r .component|jq -r .measures|jq '[.[]|select(.metric=="duplicated_lines_density")][0]'|jq -r .value);
csm=$(echo "$sonar"|jq -r .component|jq -r .measures|jq '[.[]|select(.metric=="code_smells")][0]'|jq -r .value);
sec=$(echo "$sonar"|jq -r .component|jq -r .measures|jq '[.[]|select(.metric=="security_hotspots")][0]'|jq -r .value);

echo "----- Local Sonar Analysis -----"
echo "  Coverage:          $cov"
echo "  Vulnerabilities:   $vul"
echo "  Bugs:              $bug"
echo "  Duplication:       $dup"
echo "  Code smells:       $csm"
echo "  Security Hotspots: $sec"
echo "--------------------------------"

if [[ $vul != "0" ]]; then
  echo "Sonar Analysis failed -> Vulnerabilities"
  exit 1;
fi

if [[ $bug != "0" ]]; then
  echo "Sonar Analysis failed -> Bugs"
  exit 1;
fi

if [[ $dup != "0.0" ]]; then
  echo "Sonar Analysis failed -> Duplication"
  exit 1;
fi

if [[ $csm != "0" ]]; then
  echo "Sonar Analysis failed -> Code smells"
  exit 1;
fi

if [[ $sec != "0" ]]; then
  echo "Sonar Analysis failed -> Security Hotspots"
  exit 1;
fi
