import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:proyek_uas/screens/drawer_screen.dart';
import 'table_screen.dart';
import 'package:proyek_uas/model/leaguecontainer.dart';
import 'package:proyek_uas/model/slideshow.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

final List<String> imgList = [
  'https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2020/10/28/1079132384.jpg',
  'https://cdn0-production-images-kly.akamaized.net/ajSbAYGDZSnbD_tkKMP2fME-lSM=/640x360/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/2912800/original/091373600_1568629838-Liga_Champions_-_PSG_Vs_Real_Madrid.jpg',
  'https://cdn0-production-images-kly.akamaized.net/aJfI3IXSKW45bw9GDb7oP6hehBs=/640x360/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/3215770/original/059556200_1598077957-PSG_vs_Bayern_Munchen.jpg',
];

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          backgroundColor: Color(0xFFA5D6A7),
          title: Text('Home'),
          centerTitle: true,
          actions: <Widget>[
            Padding(padding: const EdgeInsets.all(9.0),
            child: Icon(Icons.search),
            )
          ],
        ),
        drawer: DrawerScreen(),
      body: SafeArea(
        child: Container(
          decoration: BoxDecoration(
              gradient: LinearGradient(
            colors: [
              const Color(0xFFEEEEEE),
              const Color(0xFFEEEEEE),
            ],
            begin: const FractionalOffset(0.0, 0.0),
            end: const FractionalOffset(0.0, 1.0),
            stops: [0.0, 1.0],
            tileMode: TileMode.clamp,
          )),
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 0),
            child: ListView(
              children: [
                SizedBox(
                  height: 30,
                ),
                 Text(
                  '\t\t\tUpcoming Match',
                  textAlign: TextAlign.left,
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                SizedBox(
                  height: 30,
                ),
                Container(
                  child: Column(
                    children: [
                      CarouselWithDotsPage(imgList: imgList),
                    ],
                  ),
                ),
                SizedBox(
                  height: 50,
                ),
                Text(
                  '\t\t\tLeague Table',
                  textAlign: TextAlign.left,
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                SizedBox(
                  height: 30,
                ),
                GridView.count(
                  padding: EdgeInsets.all(10),
                  shrinkWrap: true,
                  crossAxisCount: 3,
                  crossAxisSpacing: 10,
                  mainAxisSpacing: 40,
                  children: [
                    GestureDetector(
                      child: LeagueContainer(image: 'assets/img/pl.png'),
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => TableScreen(code: 'PL'),
                            ));
                      },
                    ),
                    GestureDetector(
                      child: LeagueContainer(image: 'assets/img/laliga.png'),
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => TableScreen(code: 'PD'),
                            ));
                      },
                    ),
                    GestureDetector(
                      child: LeagueContainer(image: 'assets/img/bundesliga.png'),
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => TableScreen(code: 'BL1'),
                            ));
                      },
                    ),
                    GestureDetector(
                      child: LeagueContainer(image: 'assets/img/seria.png'),
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => TableScreen(code: 'SA'),
                            ));
                      },
                    ),
                    GestureDetector(
                      child: LeagueContainer(image: 'assets/img/ligue1.png'),
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => TableScreen(code: 'FL1'),
                            ));
                      },
                    ),
                    GestureDetector(
                      child: LeagueContainer(image: 'assets/img/nos.png'),
                      onTap: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => TableScreen(code: 'PPL'),
                            )
                        );
                      },
                    ),
                  ],
                )
              ],
            ),
          ),
        ),
      ),
    );
  }

}
