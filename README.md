URL Shortener
===================

Project to short url.


Running locally
---------------------

To start locally, just run the command bellow.

    $ sudo chmod +x start.sh
    $ ./start.sh


Short URLs
-----------------------------

To short an URL, access the endpoint bellow. NOTE: the URL must start with **https**.

    http://localhost:8080/doShort?url=<your_url>

The expected output is something like the string bellow.

    https://sho.rt/cMtFNJ

Accessing shortened URLs
-----------------------------

To access a website with the previous generated shortened URL, just access the endpoint bellow.

    http://localhost:8080/redirect?shortenedUrl=<shortened_url>

Example:

    http://localhost:8080/redirect?shortenedUrl=https://sho.rt/cMtFNJ

Additional statistics
-----------------------------

To view the number of times the URLs were accessed, visit the endpoint bellow.

    http://localhost:8080/statistics

Storage
-----------------------------

The data is stored in a in-memory database, called H2.

Running tests
-----------------------------

To run the tests, execute the command:

    ./gradlew test