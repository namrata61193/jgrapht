#!/bin/bash

function clone_jgrapht_if_needed() {
  echo cs498dm: cloning JGraphT if needed
  if [ ! -d jgrapht ]; then
    git clone git://github.com/jgrapht/jgrapht.git
  fi
  cd jgrapht
  git checkout 9d75fdc8cd3fdb7ad853c07b3c0691a84b8b4400
}

function add_cobertura_if_needed() {

  cd jgrapht-core
  echo cs498dm: adding Cobertura if needed
  if ! grep cobertura pom.xml; then
    sed -i '/<plugins/a\
            <plugin>\
                <groupId>org.codehaus.mojo</groupId>\
                <artifactId>cobertura-maven-plugin</artifactId>\
                <version>2.6</version>\
            </plugin>' pom.xml
  fi
}

function run_cobertura() {
  echo cs498dm: running Cobertura
  mvn -q cobertura:cobertura | grep -v "Data file does not contain instrumentation information"
  dir=$(pwd)/target/site
  ( cd ${dir}; zip -rq cobertura.zip cobertura ) # even better would be to expose coverage via Jenkins!
  echo cs498dm: Cobertura report is in ${dir}/cobertura and packed in ${dir}/cobertura.zip
  echo cs498dm: you may want to copy the coverage with: scp $(uname -n):${dir}/cobertura.zip .
  echo cs498dm: You should add some tests to increase statement coverage\!
}

function copy_modified_tests_to_SVN() {
  echo cs498dm: copying modified tests to SVN
  for file in $(git status -s src/test | grep -E '^ M' | cut -f3 -d' '); do
    cp ${file} ../../
    echo cs498dm: you likely want to execute this: svn add $(basename ${file})
  done
}

#clone_jgrapht_if_needed
add_cobertura_if_needed
run_cobertura
#copy_modified_tests_to_SVN
