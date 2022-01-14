class UserModel {
  String? uid;
  String? email;
  String? name;
  String? club;

  UserModel({this.uid, this.email, this.name, this.club});

  // receiving data from server
  factory UserModel.fromMap(map) {
    return UserModel(
      uid: map['uid'],
      email: map['email'],
      name: map['name'],
      club: map['club'],
    );
  }

  // sending data to our server
  Map<String, dynamic> toMap() {
    return {
      'uid': uid,
      'email': email,
      'name': name,
      'club': club,
    };
  }
}
