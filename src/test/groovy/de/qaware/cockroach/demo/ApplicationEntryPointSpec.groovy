package de.qaware.cockroach.demo

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title("Application Entry Point")
class ApplicationEntryPointSpec extends Specification {

    @Subject
    private ApplicationEntryPoint applicationEntryPoint = new ApplicationEntryPoint()

    def "GetClasses"() {
        when: "I retrieve the classes"
        def classes = applicationEntryPoint.getClasses()

        then: "There is at least one class returned"
        !classes.isEmpty()
    }
}
