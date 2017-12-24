
### CheckTranscriptUpdate.java
>Target of this file is to scrape data from https://www3.reg.cmu.ac.th/transcript/ that has the date time of up-to-date data. So I use Jsoup to extract the specific data in `p` element with id `update-at`, then compare with the pre-defined target date. After comparing the current result and the pre-defined one, it will send the HTTP request to trigger Webhook - a service of [IFTTT](https://ifttt.com/) - then IFTTT android app will notify me with its notification.
>#### Realted Libraries
>+ [Lombok 1.16.18](https://projectlombok.org/download)
>+ [Jsoup 1.11.2](https://jsoup.org/download)
>+ [Jersey Bundle 1.19.4](https://mvnrepository.com/artifact/com.sun.jersey/jersey-bundle/1.19.4)
>+ [jackson all 1.9.9](http://www.java2s.com/Code/Jar/j/Downloadjacksonall199jar.htm)
>+ [HttpCore 4.4.7 and HttpClient 4.5.4](https://hc.apache.org/downloads.cgi)
>
>#### Thanks to
>+ [IFTTT Java class by fergalhanley](https://gist.github.com/fergalhanley/c723ef8052f397a43d459ce8096c4b64)