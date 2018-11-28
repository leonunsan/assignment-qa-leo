package waes.rest.resource;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class DataProvider {
	static String baseUrl = "http://localhost:8081/waesheroes/api/v1";
	
	public static String getUrl() {
		return baseUrl;
	}
	public static Stream<Arguments> getUserInformation() {
		return Stream.of(
			Arguments.of("admin",true, "1984-04-16","a.admin@wearewaes.com","Amazing Admin","Change the course of a waterfall."),
			Arguments.of("dev",false, "1999-10-10","zd.dev@wearewaes.com","Zuper Dooper Dev","Debug a repellent factory storage."),
			Arguments.of("tester",false, "2014-07-15","as.tester@wearewaes.com","Al Skept-Cal Tester","Voltage AND Current.")
			);
	}
	
	
	public static Stream<Arguments> getInvalidUserInformation() {
		return Stream.of(
			Arguments.of("superadmin"),
			Arguments.of("newdev"),
			Arguments.of("oldtester")
			);
	}	
	
	public static Stream<Arguments> getAuthAllUsers() {
		return Stream.of(
			Arguments.of("Basic YWRtaW46aGVybw==")
			);
	}
	
	public static Stream<Arguments> getInvalidAuthAllUsers() {
		return Stream.of(
			Arguments.of("Basic ZGV2OndpemFyZA=="),
			Arguments.of("Basic dGVzdGVyOm1hbmlhYw==")
			);
	}
	
	public static Stream<Arguments> getAuthUser() {
		return Stream.of(
			Arguments.of("Basic YWRtaW46aGVybw==",true, "1984-04-16","a.admin@wearewaes.com","Amazing Admin","Change the course of a waterfall."),
			Arguments.of("Basic ZGV2OndpemFyZA==",false, "1999-10-10","zd.dev@wearewaes.com","Zuper Dooper Dev","Debug a repellent factory storage."),
			Arguments.of("Basic dGVzdGVyOm1hbmlhYw==",false, "2014-07-15","as.tester@wearewaes.com","Al Skept-Cal Tester","Voltage AND Current.")
			);
	}
	
	public static Stream<Arguments> getInvalidAuthUser() {
		return Stream.of(
			Arguments.of("Basic YWRtaW46dGVzdGx0ZXN0YQ==",true, "1984-04-16","a.admin@wearewaes.com","Amazing Admin","Change the course of a waterfall."),
			Arguments.of("Basic YXNkZGQ6d2l6YXJk",false, "1999-10-10","zd.dev@wearewaes.com","Zuper Dooper Dev","Debug a repellent factory storage."),
			Arguments.of("Basic dGVzdGVyOndpemFyZA==",false, "2014-07-15","as.tester@wearewaes.com","Al Skept-Cal Tester","Voltage AND Current.")
			);
	}
	
	public static Stream<Arguments> getSignUser() {
		return Stream.of(			
			Arguments.of("Basic bGVvdXNlcjp0ZXN0bHRlc3Q=", "leouser",true, "1990-11-17","leouser@wearewaes.com","Leonardo","testltest","Kamehameha"),
			Arguments.of("Basic am9hb3VzZXI6dGVzdGx0ZXN0", "joaouser",false, "1994-12-12","joaouser@wearewaes.com","João","testltest","Run"),
			Arguments.of("Basic cGF1bG91c2VyOnRlc3RsdGVzdA==", "paulouser",false, "1998-05-01","paulouser@wearewaes.com","Paulo","testltest","Gamer")
			);
	}
	
	public static Stream<Arguments> getInvalidSignUser() {
		return Stream.of(
			Arguments.of("admin",true, "1990-11-17","leo.user@wearewaes.com","Leonardo","testltest","Kamehameha","User registration error: The username 'admin' already exists."),
			Arguments.of("asjoaouser",false, "1994-12-12","zd.dev@wearewaes.com","João","testltest","Run","User registration error: The email 'zd.dev@wearewaes.com' is already registered.")
			);
	}
	
	
	
	public static Stream<Arguments> getUpdateUser() {
		return Stream.of(				
				Arguments.of("Basic bGVvdXNlcjp0ZXN0bHRlc3Q=", "leouser",true, "1990-11-17","leouser@wearewaes.com","Leonardo","testltest","Kamehameha"),
				Arguments.of("Basic am9hb3VzZXI6dGVzdGx0ZXN0", "joaouser",false, "1994-12-12","joaouser@wearewaes.com","João","testltest","Run"),
				Arguments.of("Basic cGF1bG91c2VyOnRlc3RsdGVzdA==", "paulouser",false, "1998-05-01","paulouser@wearewaes.com","Paulo","testltest","Gamer")
			);
	}
	
	public static Stream<Arguments> getUpdateInvalidUser() {
		return Stream.of(
			Arguments.of("Basic YWRtaW46dGVzdGx0ZXN0YQ==",true, "1990-10-17","leo.user123@wearewaes.com","Leonardo 2","testltest","Kamehameha 2"),
			Arguments.of("Basic YXNkZGQ6d2l6YXJk",true, "1994-10-12","joao.user123@wearewaes.com","João 2","testltest","Run 2"),
			Arguments.of("Basic dGVzdGVyOndpemFyZA==",false, "1998-12-01","paulo.user123@wearewaes.com","Paulo 2","testltest","Gamer 2")
			);
	}
	
	public static Stream<Arguments> getDeleteUser() {
		return Stream.of(
			Arguments.of("Basic bGVvdXNlcjp0ZXN0bHRlc3Q=", "leouser",true, "1990-11-17","leouser@wearewaes.com","Leonardo","testltest","Kamehameha"),
			Arguments.of("Basic am9hb3VzZXI6dGVzdGx0ZXN0", "joaouser",false, "1994-12-12","joaouser@wearewaes.com","João","testltest","Run"),
			Arguments.of("Basic cGF1bG91c2VyOnRlc3RsdGVzdA==", "paulouser",false, "1998-05-01","paulouser@wearewaes.com","Paulo","testltest","Gamer")
			
			);
	}
	
	public static Stream<Arguments> getInvalidDeleteUser() {
		return Stream.of(
			Arguments.of("Basic YWRtaW46dGVzdGx0ZXN0YQ=="),
			Arguments.of("Basic YXNkZGQ6d2l6YXJk"),
			Arguments.of("Basic dGVzdGVyOndpemFyZA==")
			);
	}

}
