Property Extender
=================

What is property extender?
-

Property extender is a standalone service which adds additional properties to business entities e.g. Client entity in this program and manages the metadata associated with those properties. Metadata refers to data that stores information about other data. In our service, attributes like name, clientId, dates of creation and updates are metadatas of that specific property object.



API Endpoint
------------
Endpoint Detail: host-url/swagger-ui.html

The list of endpoints related to Client object-

* POST: host-url/clients [Adding a new client]
* GET: host-url/clients [Retrieving all clients in database]
* GET: host-url/clients/{clientId} [Retrieving a single client by ID]

The list of endpoints related to Property object-

* POST: host-url/properties [Adding a new property]
* GET: host-url/properties [Retrieving all properties in database]
* GET: host-url/properties/{propertyId} [Retrieving a property by ID]
* GET: host-url/properties/{clientId} [Retrieving all properties of a client by client ID]
