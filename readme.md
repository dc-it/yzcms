## yzcms

### 命名
- sys-系统     
- cms-网站元数据
- aut-面向作者的内容

### 数据库
- 使用分布式id：文章表、文章内容表、文章标签表、文章标签关联表、文件表，
其他表都用自增id

### 模板

#### 存储位置

可存储于项目内classpath:templates下，也可以存储进（远程）单独的minio文件服务器

#### test

this is a test