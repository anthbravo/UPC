import 'package:flutter/material.dart';
import 'package:platzi_example/card_image_list.dart';
import 'package:platzi_example/gradient_back.dart';

class Header extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final header = Stack(
      children: [GradientBack("Popular"), CardImageList()],
    );
    return header;
  }
}
