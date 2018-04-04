###  关于代码的几个建议

* 整个工程的名字首字母得大写，而不是test2
* 另外代码组织的有点乱
  * 例如，数据机构TestData可以新建一个package，后面名为com.monflood.record，放在这个包下面
  * 然后像TraverseFolder，还有ReadWrite，还有ProcessData里面的读写文件的操作应该抽象出来，统一放在一个package里面。
  * 然后这块我觉得TestData，应该是只有两个属性一个是时间戳，一个是某一个属性，比如命名为String AttrValue。然后也应该为分段建一个数据结构，可以为该分段的起始时间，以及该分段一List<TestData> 这样会合理一点。然后应该是在外面写一个最外面那个helloword里面写一个for循环依次把第i个属性读进来。
* 关于组织代码这块，我给你发了一个工程，你可以看一下，不用管功能，就看一下包的命名方式，组织方式。