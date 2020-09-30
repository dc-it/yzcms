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

- 可存储于项目内classpath:templates下，也可以存储进（远程）单独的minio文件服务器

#### JWT令牌续期

- jwt生成的token，过期后解析会报过期异常ExpiredJwtException，可以从过期异常中获取存储用户相关信息的负载payload
- 续期实现原理：      
设置一个过期后的允许过期时间段。在token过期时间内，从过期异常中获取负载payload，修改创建时间为当前时间，然后设置过期时间，生成新的token返回给前端(具体实现看JwtTokenUtil.java)     


---

