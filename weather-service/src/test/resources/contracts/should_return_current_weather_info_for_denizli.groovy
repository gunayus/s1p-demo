import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should return current weather info'

    request {
        url '/weather/current/TR/Denizli'
        method GET()
    }

    response {
        status 200
		headers {
			contentType('application/json')
		}
        body (
                "temperature": 39.15,
                "weatherId": 800,
                "weatherIcon": "01d",
                "name": "Denizli",
                "timestamp": 1505824065
        )
    }
}