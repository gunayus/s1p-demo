import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should return current weather info'

    request {
        url '/weather/current/TR/Ankara'
        method GET()
    }

    response {
        status 200
		headers {
			contentType('application/json')
		}
        body (
                "temperature": 38.15,
                "weatherId": 802,
                "weatherIcon": "03d",
                "name": "Ankara",
                "timestamp": 1505824065
        )
    }
}