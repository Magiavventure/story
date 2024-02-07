# Magiavventure - Story
[![codecov](https://codecov.io/gh/Magiavventure/story/graph/badge.svg?token=EJ31IAO95X)](https://codecov.io/gh/Magiavventure/story)
![Docker Image Version (latest semver)](https://img.shields.io/docker/v/magiavventure/story)
![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/Magiavventure/story/build.yml)

This service allows to create/update/delete and find the stories used by Magiavventure App.

## Configuration
The properties exposed to configure this project are:
```properties
logging.level.it.magiavventure="string"                                                      # Logging level package magiavventure
magiavventure.lib.common.errors.service-errors-messages.{error-key}.code="string"            # The exception key error code
magiavventure.lib.common.errors.service-errors-messages.{error-key}.message="string"         # The exception key error message
magiavventure.lib.common.errors.service-errors-messages.{error-key}.description="string"     # The exception key error description
magiavventure.lib.common.errors.service-errors-messages.{error-key}.status=integer           # The exception key error status
```

## Error message map
The error message map is a basic system for return the specific message in the error response, 
the configuration path is for branch **service-error-messages**.
This branch setting a specific error message to **it.magiavventure.story.error.StoryException**


## API
### Create Story
This request allow to create a new story

`POST /v1/saveStory`

```bash
curl -X 'POST' \
  '<hostname>:<port>/v1/saveStory' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "title": "title",
    "subtitle": "subtitle",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "author": "author",
    "categories": [
        {"id":"7605b172-ab5f-4af7-b12b-e668081f2cbf", "name":"category", "background":"background"}
    ]
}'
```
`Response`

```text
HTTP/1.1 201 CREATED
connection: keep-alive 
content-type: application/json 
date: Sun,10 Dec 2023 09:24:25 GMT 
keep-alive: timeout=60 
transfer-encoding: chunked 

{
    "title": "title",
    "subtitle": "subtitle",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "categories": [
        {"id":"7605b172-ab5f-4af7-b12b-e668081f2cbf", "name":"category", "background":"background"}
    ]
}
```

### Update Category
This request allow to update a story

`PUT /v1/updateStory`

```bash
curl -X 'PUT' \
  '<hostname>:<port>/v1/updateCategory' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "id": "7605b172-ab5f-4af7-b12b-e668081f2cbf",
    "title": "title",
    "subtitle": "subtitle",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "categories": [
        {"id":"7605b172-ab5f-4af7-b12b-e668081f2cbf", "name":"category", "background":"background"}
    ]
}'
```
`Response`

```text
HTTP/1.1 200 OK
connection: keep-alive 
content-type: application/json 
date: Sun,10 Dec 2023 09:24:25 GMT 
keep-alive: timeout=60 
transfer-encoding: chunked 

{
  "id": "<id>",
  "name": "<name>",
  "background": "<background>"
}
```

`Errors`

List of code errors that the api can return

```properties
story-not-found  #(404 - in case a story is not found with the id in body request)
```

### Find All Stories
This request allow to find all stories

`GET /v1/retrieveStories`

```bash
curl -X 'GET' \
  '<hostname>:<port>/v1/retrieveStories' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json'
```
`Response`

```text
HTTP/1.1 200 OK
connection: keep-alive 
content-type: application/json 
date: Sun,10 Dec 2023 09:24:25 GMT 
keep-alive: timeout=60 
transfer-encoding: chunked 

[
  {
    "id": "7605b172-ab5f-4af7-b12b-e668081f2cbf",
    "title": "title",
    "subtitle": "subtitle",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "categories": [
        {"id":"7605b172-ab5f-4af7-b12b-e668081f2cbf", "name":"category", "background":"background"}
    ]
  }
]
```

### Find Story by ID
This request allow to find a story by ID

`PUT /v1/retrieveStory/{id}`

```bash
curl -X 'GET' \
  '<hostname>:<port>/v1/retrieveStory/{id}' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json'
```
`Response`

```text
HTTP/1.1 200 OK
connection: keep-alive 
content-type: application/json 
date: Sun,10 Dec 2023 09:24:25 GMT 
keep-alive: timeout=60 
transfer-encoding: chunked 

{
    "id": "7605b172-ab5f-4af7-b12b-e668081f2cbf",
    "title": "title",
    "subtitle": "subtitle",
    "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "categories": [
        {"id":"7605b172-ab5f-4af7-b12b-e668081f2cbf", "name":"category", "background":"background"}
    ]
}
```

`Errors`

List of code errors that the api can return

```properties
story-not-found  #(404 - in case a story is not found)
```

### Delete Story by ID
This request allow to delete a story by ID

`DELETE /v1/deleteStory/{id}`

```bash
curl -X 'DELETE' \
  '<hostname>:<port>/v1/deleteStory/{id}' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json'
```
`Response`

```text
HTTP/1.1 204 NO-CONTENT
connection: keep-alive 
content-type: application/json 
date: Sun,10 Dec 2023 09:24:25 GMT 
keep-alive: timeout=60 
transfer-encoding: chunked 
```

`Errors`

List of code errors that the api can return

```properties
story-not-found  #(404 - in case a story is not found)
```

## Running local
For run the service in local environment need to execute following actions

### Running service
Run the service with the following profile:
1. "local" for local environment configuration