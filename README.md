TrackingSwallower
=================

This is a Play application using ReactiveMongoDB that allows you to store tracking data in a MongoDB database.

# Installation
You need to install play2 and mongoDB
http://www.playframework.com/

# Usage

```
./activator run
```

You can then use Postman in order to store a tracking data, set the URL to http://localhost:9000, the verb to POST, the content-type to application/json and the tracking data must have this stucture :


```json
{
        "cookie_id": String,
        "email": String,
    	"session_id": String, 
    	"referer": String,
    	"timestamp": String,
    	"event": String 
}
```
