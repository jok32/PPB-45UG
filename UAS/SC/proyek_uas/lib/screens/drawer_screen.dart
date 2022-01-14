import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:proyek_uas/model/user_model.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:proyek_uas/screens/login_screen.dart';
import 'package:proyek_uas/screens/profile_screen.dart';

class DrawerScreen extends StatefulWidget {
  const DrawerScreen({ Key? key }) : super(key: key);

  @override
  _DrawerScreenState createState() => _DrawerScreenState();
}

class _DrawerScreenState extends State<DrawerScreen> {
  User? user = FirebaseAuth.instance.currentUser;
  UserModel loggedInUser = UserModel();

  @override
  void initState() {
    super.initState();
    FirebaseFirestore.instance
        .collection("users")
        .doc(user!.uid)
        .get()
        .then((value) {
      this.loggedInUser = UserModel.fromMap(value.data());
      setState(() {});
    });
  }
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        children: <Widget>[
          UserAccountsDrawerHeader(
            decoration: BoxDecoration(
              color: Color(0xFFA5D6A7),
            ),
            accountName: Text("Hi, ${loggedInUser.name}",
            style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.black,
                  )),
            currentAccountPicture: CircleAvatar(
              backgroundImage: AssetImage("assets/img/person.jpg")
            ),
            accountEmail: Text("${loggedInUser.email}",
            style: TextStyle(
                    fontSize: 15,
                    fontWeight: FontWeight.bold,
                    color: Colors.black,
                  )
              ),
            ), 
            DrawerListTile(
              iconData: Icons.person,
              title: "Profil",
              onTilePressed: (){
                Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => ProfileScreen()),
                        );
              },
            ),
            DrawerListTile(
              iconData: Icons.exit_to_app,
              title: "Logout",
              onTilePressed: (){
                logout(context);
              },
            ),
            
          
        ],
      )
    );
  }
  Future<void> logout(BuildContext context) async {
    await FirebaseAuth.instance.signOut();
    Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => LoginScreen()));
  }
}


class DrawerListTile extends StatelessWidget {
  final IconData? iconData;
  final String? title;
  final VoidCallback? onTilePressed;

  const DrawerListTile({ Key? key, this.iconData, this.title, this.onTilePressed}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListTile(
      onTap: onTilePressed,
      dense: true,
      leading: Icon(iconData),
      title: Text(title!, style: TextStyle(fontSize: 16),),
    );
  }
   
}