# quaresima
REST API that gives you holidays info

# Usage

    >http 138.68.177.123/days/2017-12-25/2017-12-27
    HTTP/1.1 200 OK
    Content-Length: 145
    Content-Type: application/json
    Date: Sat, 13 Jan 2018 21:24:39 GMT

    [
        {
            "day": "2017-12-25",
            "dayOfWeek": 1,
            "holiday": [
                "Santo Natale"
            ]
        },
        {
            "day": "2017-12-26",
            "dayOfWeek": 2,
            "holiday": [
                "Santo Stefano"
            ]
        },
        {
            "day": "2017-12-27",
            "dayOfWeek": 3,
            "holiday": []
        }
    ]
