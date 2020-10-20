# NMEC: 93236

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
* documentos gerados no diretório

## Lab 1.3

e) 
Todos os processos em execução
```bash
docker ps --all
```
Usando o terminal no diretório do Dockerfile, constroi-se a aplicação da seguinte forma:
```bash
docker build --tag <nome>:<versão> .
```
Abrir um container baseado numa dada imagem
```bash
docker run --publish <porto que o host adota>:<porto do container> --detach --name bb <nome>:<versão>
```

```bash
docker rm --force bb
```

```bash
$ docker images -a

eg_postgresql            latest              a3a790291485        46 hours ago        401MB
bulletinboard            1.0                 4f6cb4c4830a        2 days ago          184MB
busybox                  latest              6858809bf669        5 weeks ago         1.23MB
portainer/portainer-ce   latest              a0a227bf03dd        6 weeks ago         196MB
docker/getting-started   latest              1f32459ef038        3 months ago        26.8MB
hello-world              latest              bf756fb1ae65        9 months ago        13.3kB
```

```bash
docker container ls -all

CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS               NAMES
a962d770378b        eg_postgresql       "bash"              18 minutes ago      Up 18 minutes       5432/tcp            magical_varahamihira
```

```bash
docker container ls

CONTAINER ID        IMAGE                    COMMAND                  CREATED             STATUS              PORTS                                                      NAMES
a962d770378b        eg_postgresql            "bash"                   17 minutes ago      Up 17 minutes       5432/tcp                                                   magical_varahamihira
de86d2a99e72        eg_postgresql            "/usr/lib/postgresql…"   18 minutes ago      Up 18 minutes       0.0.0.0:32771->5432/tcp                                    pg_test
9b46301a3f33        portainer/portainer-ce   "/portainer"             2 days ago          Up 30 minutes       0.0.0.0:8001->8001/tcp, 8000/tcp, 0.0.0.0:9000->9000/tcp   portainer
```

```bash
docker container ls -all

CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS               NAMES
a962d770378b        eg_postgresql       "bash"              23 minutes ago      Up 23 minutes       5432/tcp            magical_varahamihira
```

usar o volume para guardar os dados da base de dados postgre
```bash 
docker run --rm --volumes-from pg_test -t -i busybox sh
```


resultdo de $ docker ps
```bash 
docker ps
CONTAINER ID        IMAGE                    COMMAND                  CREATED             STATUS              PORTS                                                      NAMES
ce7c54e376df        busybox                  "sh"                     4 minutes ago       Up 4 minutes                                                                   busy_euler
19203b8c529b        eg_postgresql            "/usr/lib/postgresql…"   4 minutes ago       Up 4 minutes        0.0.0.0:32768->5432/tcp                                    pg_test
9b46301a3f33        portainer/portainer-ce   "/portainer"             6 days ago          Up 24 minutes       0.0.0.0:8001->8001/tcp, 8000/tcp, 0.0.0.0:9000->9000/tcp   portainer

```

f)
```bash
$ docker image ls
REPOSITORY               TAG                 IMAGE ID            CREATED              SIZE
composetest_web          latest              7347bf4d08ac        About a minute ago   196MB
busybox                  latest              f0b02e9d092d        6 days ago           1.23MB
eg_postgresql            latest              a3a790291485        6 days ago           401MB
bulletinboard            1.0                 4f6cb4c4830a        7 days ago           184MB
redis                    alpine              bd71e6db4a54        5 weeks ago          32.2MB
busybox                  <none>              6858809bf669        5 weeks ago          1.23MB
python                   3.7-alpine          295b051ee125        5 weeks ago          41.7MB
portainer/portainer-ce   latest              a0a227bf03dd        7 weeks ago          196MB
docker/getting-started   latest              1f32459ef038        3 months ago         26.8MB
hello-world              latest              bf756fb1ae65        9 months ago         13.3kB
```

```bash
$ docker-compose ps
     Name           Command      State       Ports    
------------------------------------------------------
composetest_re   docker-         Up      6379/tcp     
dis_1            entrypoint.sh                        
                 redis ...                            
composetest_we   flask run       Up      0.0.0.0:5000-
b_1                                      >5000/tcp
```

```bash
$ docker-compose run web env
Creating composetest_web_run ... done
PATH=/usr/local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
HOSTNAME=0387738ec010
TERM=xterm
FLASK_ENV=development
LANG=C.UTF-8
GPG_KEY=0D96DF4D4110E5C43FBFB17F2D347EA6AA65421D
PYTHON_VERSION=3.7.9
PYTHON_PIP_VERSION=20.2.3
PYTHON_GET_PIP_URL=https://github.com/pypa/get-pip/raw/fa7dc83944936bf09a0e4cb5d5ec852c0d256599/get-pip.py
PYTHON_GET_PIP_SHA256=6e0bb0a2c2533361d7f297ed547237caf1b7507f197835974c0dd7eba998c53c
FLASK_APP=app.py
FLASK_RUN_HOST=0.0.0.0
HOME=/root
```

```bash
$ docker-compose down --volumes
Removing composetest_web_run_b2b8779b384f ... done
Removing composetest_web_1                ... done
Removing composetest_redis_1              ... done
Removing network composetest_default
```
* Qual a relevância de configurar “volumes” quando se pretende preparar um container para servir uma
base de dados?
Quando um container é destruido perde-se os seus dados quando não utilizando um volume. Assim, definindo e usando um volume, os dados podem persistir mesmo após o shutdown do container onde estava a correr a base de dados.\


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

**SIGTERM**
SIGTERM é um sinal conhecido por um processo informático em sistemas operativos POSIX. Este é o sinal padrão enviado pelos comandos kill e killall. Ele causa o término do processo, como em SIGKILL, porém pode ser interpretado ou ignorado pelo processo. Com isso, SIGTERM realiza um encerramento mais amigável, permitindo a liberação de memória e o fechamento dos arquivos.

**SIGKILL**
SIGKILL é um sinal conhecido por um processo informático em sistemas operativos POSIX. SIGKILL é uma constante numérica definida em signal.h, que pode variar em diversos sistemas. Este sinal causa uma terminação do processo, que não pode ser ignorada (ao contrario de SIGTERM).

### Docker Cheat Sheet
#### Build
```bash
docker build -t myimage:1.0 
```
* constroi uma imagem a partir do Dockerfile presente no diretório atual

```bash
docker image ls
```
* lista todas as imagens que estão localmente guardadas com o Docker Engine

```bash
docker image rm alpine:3.4
```
* elimina uma image guardada localmente

#### Run
```bash
docker container run --name web -p 5000:80 alpine:3.9
```
* corre um container a partir da versão 3.9 do Alpine
* nomeira de "web" o container que está a correr
* expõe a porta 80 do container como porta 5000 externamente

**outras tags**:
* --publish asks Docker to forward traffic incoming on the host’s port 8000 to the container’s port 8080. Containers have their own private set of ports, so if you want to reach one from the network, you have to forward traffic to it in this way. Otherwise, firewall rules will prevent all network traffic from reaching your container, as a default security posture.
* --detach asks Docker to run this container in the background.
* --name specifies a name with which you can refer to your container in subsequent commands, in this case bb.

```bash
docker container stop web
```
* para a execução do container através de **SIGTERM**

```bash
docker container kill web
```
* para a execução do container através do **SIGKILL**

```bash
docker network ls
```
* lista todas as networks

```bash
docker container ls
```
* Lista os containers em execução
* com o parametro --all, ele lista também o que não estão em execução

```bash
docker container rm -f $(docker ps -aq)
```
* elimina todos os containers, estejam em execução ou não

```bash
docker container logs --tail 100 web
```
* faz print às últimas 100 linhas do ficheiro log do container

### Share
```bash
docker pull myimage:1.0
```
* faz Pull à imagem do registry

```bash
docker tag myimage:1.0 myrepo/myimage:2.0
```
* renomeia a imagem

```bash
docker push myrepo/myimage:2.0
```
* faz Push de uma imagem para o registry

### Docker compose
No Dockerfile,
```Dockerfile
WORKDIR /code
```
define o diretorio de trabalho como sendo /code;
```Dockerfile
ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0
```
define as variaveis de ambiente para a utilização do flask;
```Dockerfile
EXPOSE 5000
```
indica que o servidor vai estar situado no porto 5000;
```yml
version: "3.8"
services:
  web:
    build: .
    ports:
      - "5000:5000"
  redis:
    image: "redis:alpine"
```
define os dois serviços que vão estar a correr (web, redis);
```bash
$ docker-compose up
```
faz build à imagem e começa os serviços definidos anteriormente;
```bash
$ docker-machine ip MACHINE_VM
```
retorna o ip da máquina onde está a correr o servidor;
```bash
$ docker-compose down
```
fecha a aplicação;
```bash
$  docker-compose up -d
```
modo detached de correr os serviços, o que significa que fica a correr em background;
```bash
$ docker-compose stop
```
parar a execução dos serviços;
```bash
$ docker-compose down --volumes
```
remove os containers associados ao docker-compose e a tag --volumes remove todos os dados usados pelo container do Redis.
