1.为了满足a包中的需求的变化:加入调料,尝试这样解决问题:
	为加牛奶的 Decaf咖啡创建一个类:
	 class DecafwithMilk{}
	为加牛奶的 Espresso咖啡创建一个类:
 	class EspressowithMilk{}
	为加牛奶且加豆浆的的 Decaf咖啡创建一个类:
 	class DecafwithMilkAndSoy{}
 	。。。

这会引起,类爆炸!这样开发,简直让人想死!尤其是,后来又加入了一个新调料:枸杞。
不能这样设计类。
