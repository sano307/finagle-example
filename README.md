## Finagle example
- The repository to test for Finagle

## Environment
- scala: 2.11.7
- sbt: 1.1.2
- IDE: Intellij
    - Version: 2018.1
    - Build: 181.4203.550
    - Released: March 27, 2018
    - sbt 1.1.2 issue fixed
        - https://developer.lightbend.com/blog/2018-03-26-sbt-1-1-2-hotfix/index.html

## Usage

```
// First command window
$ git clone https://github.com/sano307/finagle-example.git
$ cd finagle-example
$ sbt compile
$ sbt "server/runMain HttpServer"
...

[info] Running HttpServer
4 08, 2018 2:31:08 午後 com.twitter.finagle.Init$$anonfun$4 apply$mcV$sp
情報: Finagle version 6.38.0 (rev=56e7cf55b5174fbb3e481e73984ea62a3a3c63da) built at 20160907-143606

// Second command window
$ sbt "client/runMain HttpClient"
...

[info] Running HttpClient
4 08, 2018 2:32:43 午後 com.twitter.finagle.Init$$anonfun$4 apply$mcV$sp
情報: Finagle version 6.38.0 (rev=56e7cf55b5174fbb3e481e73984ea62a3a3c63da) built at 20160907-143606
Success: Hello
Close client
[success] Total time: 6 s, completed 2018/04/08 14:32:44
```
