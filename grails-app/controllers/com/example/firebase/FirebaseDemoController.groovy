package com.example.firebase

class FirebaseDemoController {
    def firebaseRef

    def index() {
        //Firebase.defaultConfig = new Config(eventTarget: event)
        //Firebase firebaseRef = new Firebase('https://torid-fire-7633.firebaseio.com')

        firebaseRef.child("first").value = "X"
        firebaseRef.child("last").value = "Doe"

        firebaseRef.on('value'){ data, error ->
            println "first name is ${data.value}"
        }

        // Writing data
        firebaseRef.value  = [
            address: [
                street: '123 Main Street',
                apt: 123,
                city: 'Columbus',
                zip: 43230,
                state: 'OH',
                country: 'USA'
            ]
        ]
        firebaseRef.onChildAdded { data, previous, error ->
            println "Add callback"
            println data
            println previous
            println error
        }

        firebaseRef.on('childChanged'){ data, previous, error ->
            println "Change callback"
            println data
            println previous
            println error
        }

        firebaseRef.on('childRemoved'){ data, previous, error ->
            println "Remove callback"
            println data
            println previous
            println error
        }

        render "Firebase Ok"
    }
}
