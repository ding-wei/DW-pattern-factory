1. Mapper在spring管理下其实是单例，为什么可以是一个
单例？ SCOPE -> application
 答:每个Mapper文件都有相对应得SQL ,应为SQL由Dao 进行管理所以是单例的

2. MyBatis在Spring集成下没有mapper的xml文件会不会
  不会因为 MyBatis映射语句可以由XML或者Annotation
