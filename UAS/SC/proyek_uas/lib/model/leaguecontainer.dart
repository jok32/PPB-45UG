import 'package:flutter/material.dart';

class LeagueContainer extends StatelessWidget {
  final String? image;

  const LeagueContainer({Key? key, this.image}) 
  : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Container(
      width: 900,
      padding: EdgeInsets.symmetric(vertical: 20),
      decoration: BoxDecoration(
        color: Color(0xffffffff),
        borderRadius: BorderRadius.circular(35),
        boxShadow: [
          BoxShadow(
            color: Colors.grey,
            blurRadius: 4,
            offset: Offset(4, 8),
          ),
        ],
      ),
      child: Image.asset(image!),
    );
  }
}
