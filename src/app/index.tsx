import React from 'react';
import {
  View,
  Text,
  StyleSheet,
  SafeAreaView,
  useWindowDimensions,
} from 'react-native';

export default function HomeScreen() {
  const { width } = useWindowDimensions();

  // Chiều rộng vùng giao diện, chừa 20px hai bên
  const contentWidth = width - 20;

  // Chiều cao các ô theo đúng tỷ lệ trong ảnh
  const topHeight = contentWidth * 0.40;
  const middleHeight = contentWidth * 0.40;
  const bottomHeight = contentWidth * 0.344;

  return (
    <SafeAreaView style={styles.safeArea}>
      <View style={[styles.container, { width: contentWidth }]}>

        {/* HÀNG 1: Ô 1 + Ô 2 */}
        <View style={[styles.row, { height: topHeight }]}>
          <View style={[styles.box, styles.box1]}>
            <Text style={styles.numberWhite}>1</Text>
          </View>

          <View style={[styles.box, styles.box2]}>
            <Text style={styles.numberWhite}>2</Text>
          </View>
        </View>

        {/* HÀNG 2: Ô 3 + Ô 4 + Ô 5 */}
        <View
          style={[
            styles.row,
            styles.middleRow,
            { height: middleHeight },
          ]}
        >
          <View style={[styles.box, styles.box3]}>
            <Text style={styles.numberBlack}>3</Text>
          </View>

          <View style={[styles.box, styles.box4]}>
            <Text style={styles.numberWhite}>4</Text>
          </View>

          <View style={[styles.box, styles.box5]}>
            <Text style={styles.numberWhite}>5</Text>
          </View>
        </View>

        {/* HÀNG 3: Ô 6 */}
        <View
          style={[
            styles.box,
            styles.box6,
            { height: bottomHeight },
          ]}
        >
          <Text style={styles.numberWhite}>6</Text>
        </View>

        {/* HỌ VÀ TÊN - MSSV */}
        <View style={styles.studentContainer}>
          <Text style={styles.studentText}>
            Phạm Tuấn Anh - BIT 240012
          </Text>
        </View>

      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  safeArea: {
    flex: 1,
    backgroundColor: '#FFFFFF',
  },

  container: {
    flex: 1,
    alignSelf: 'center',
    paddingTop: 10,
  },

  row: {
    flexDirection: 'row',
    gap: 10,
  },

  middleRow: {
    marginTop: 10,
  },

  box: {
    justifyContent: 'center',
    alignItems: 'center',
  },

  // Ô 1
  box1: {
    flex: 1,
    backgroundColor: '#1976F3',
  },

  // Ô 2
  box2: {
    flex: 1,
    backgroundColor: '#F5363C',
  },

  // Ô 3
  box3: {
    flex: 0.9,
    backgroundColor: '#FFD719',
  },

  // Ô 4
  box4: {
    flex: 0.6,
    backgroundColor: '#27AE60',
  },

  // Ô 5 rộng gấp đôi ô 3 và ô 4
  box5: {
    flex: 2,
    backgroundColor: '#813CE6',
  },

  // Ô 6
  box6: {
    marginTop: 10,
    width: '100%',
    backgroundColor: '#FF7514',
  },

  numberWhite: {
    color: '#FFFFFF',
    fontSize: 58,
    fontWeight: '700',
  },

  numberBlack: {
    color: '#000000',
    fontSize: 58,
    fontWeight: '700',
  },

  studentContainer: {
    position: 'absolute',
    bottom: 90,
    left: 0,
    right: 0,
    alignItems: 'center',
  },

  studentText: {
    color: '#444444',
    fontSize: 18,
    fontWeight: '500',
  },
});