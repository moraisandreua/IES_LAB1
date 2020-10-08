# Lab1

## Lab 1.1

b) **archetype, groupId e artifactId** 
archetype -> Archetype é um template que cerve como modelo de criação de ficheiros nos diretórios. Ou seja, é o que permite que vários desenvolvedores sigam a mesma lógica de construção do projeto de forma a que nenhum deles tenha dificuldade e seja consistente com o trabalho dos outros desenvolvedores. Ajuda também, aos novos desenvolvedores, a entender a estrutura "normal" de um projeto em Maven e as melhores práticas empregues pelo Maven.

groupId -> é o identificador único que permite distinguir um dado projeto de todos os outros. Um groupId deve serguir as regras de nomenclatura dos packages do java:
    1.  Deve estruturar-se de forma inversa aos domínio da internet (com.google.firebase)
    2.  Se o domínio contiver um hífen, então no grupId, esse hífen deve ser convertido em underscore.
    3. Se o domínio contiver palavras reservadas ou começar por um número/caracter especial, entçao deve ser adicionado um underscore de modo a tornar o groupId válido.
Podem ser criados vários groupId's.

artifactId -> nome do ficheiro jar sem a sua versão escrita. Deve conter apenas caracteres minúsculos e não deve ter caracteres especiais.


i) **o que é um maven goal? quais os principais maven goals e a respetiva sequencia de execução?**
Cada fase é uma sequencia de *goals* e cada *goal* é responsavel por uma tarefa específica.
Quando nós chamamos uma fase, todos os goals a ela associados são executados por uma certa ordem.
Portanto, os goals são os constituintes de uma fase que, executados por uma certa ordem permitem que esta mesma fase seja executada.

Por exemplo, para listar todos os goals associados à fase *compile*, podemos usar:
```bash
mvn help:describe -Dcmd=compile
```
Neste caso, o retorno seria:
```bash
compile' is a phase corresponding to this plugin:
org.apache.maven.plugins:maven-compiler-plugin:3.1:compile
```
O texto acima indica que o *compile goal* do *compiler plugin* está adjacente à *compile phase*
Assim, a sequência de execução é fixa e predefinida para uma dada phase.


## Lab 1.2


## Lab 1.3


## NOTES

There are three built-in **life cycles** in maven:
*default*: the main life cycle as it's responsible for project deployment
*clean*: to clean the project and remove all files generated by the previous build
*site*: to create the project's site documentation
Each life cycle consists of a sequence of phases. The default build life cycle consists of 23 phases as it's the main build lifecycle.
On the other hand, clean life cycle consists of 3 phases, while the site lifecycle is made up of 4 phases.

A **Maven phase** represents a stage in the Maven build lifecycle. Each phase is responsible for a specific task.
*clean*
* pre-clean - execute processes needed prior to the actual project cleaning
* clean - remove all files generated by the previous build
* post-clean - execute processes needed to finalize the project cleaning

*default*
* validate - validate the project is correct and all necessary information is available.
* initialize - initialize build state, e.g. set properties or create directories.
* generate-sources - generate any source code for inclusion in compilation.
* process-sources - process the source code, for example to filter any values.
* generate-resources - generate resources for inclusion in the package.
* process-resources - copy and process the resources into the destination directory, ready for packaging.
* compile - compile the source code of the project.
* process-classes - post-process the generated files from compilation, for example to do bytecode enhancement on Java classes.
* generate-test-sources - generate any test source code for inclusion in compilation.
* process-test-sources - process the test source code, for example to filter any values.
* generate-test-resources - create resources for testing.
* process-test-resources - copy and process the resources into the test destination directory.
* test-compile - compile the test source code into the test destination directory.
* process-test-classes - post-process the generated files from test compilation, for example to do bytecode enhancement on Java classes.
* test - run tests using a suitable unit testing framework. These tests should not require the code be packaged or deployed.
* prepare-package - perform any operations necessary to prepare a package before the actual packaging. This often results in an unpacked, processed version of the package.
* package - take the compiled code and package it in its distributable format, such as a JAR.
* pre-integration-test - perform actions required before integration tests are executed. This may involve things such as setting up the required environment.
* integration-test - process and deploy the package if necessary into an environment where integration tests can be run.
* post-integration-test - perform actions required after integration tests have been executed. This may including cleaning up the environment.
* verify - run any checks to verify the package is valid and meets quality criteria.
* install - install the package into the local repository, for use as a dependency in other projects locally.
* deploy - done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

*site*
* pre-site - execute processes needed prior to the actual project site generation.
* site - generate the project's site documentation.
* post-site - execute processes needed to finalize the site generation, and to prepare for site deployment.
* site-deploy - deploy the generated site documentation to the specified web server

Phases are executed in a specific order. This means that if we run a specific phase using the command:
```bash
$mvn <Phase>
```

**Maven Plugin**
A Maven plugin is a group of goals. However, these goals aren't necessarily all bound to the same phase.
For example, here's a simple configuration of the Maven Failsafe plugin which is responsible for running integration tests:
```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-failsafe-plugin</artifactId>
            <version>${maven.failsafe.version}</version>
            <executions>
                <execution>
                    <goals>
                        <goal>integration-test</goal>
                        <goal>verify</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
