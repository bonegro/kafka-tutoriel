package net.assam.kafka.tutoriel.payload;

public record User(int id, String firstName, String lastName) {

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
