# NoteApp-Android

一个基于 Jetpack Compose 的安卓笔记应用，用于练习现代 Android 开发架构。

---

## 功能

- 添加笔记
- 删除笔记（支持撤销）
- 编辑笔记
- 按标题 / 日期 / 颜色排序
- 动态切换排序方式（升序 / 降序）

---

## 技术栈

- Kotlin
- Jetpack Compose
- MVVM 架构
- Room 数据库
- Hilt 依赖注入
- Kotlin Coroutines + Flow

---

## 架构

项目采用典型的 MVVM 分层结构：

UI (Jetpack Compose)
 ↓
 ViewModel
 ↓
 UseCase
 ↓
 Repository
 ↓
 Room Database



### 核心设计

- **State 驱动 UI（UDF）**
- 使用 `State` 管理界面状态
- 使用 `SharedFlow` 处理一次性事件（Snackbar / Navigation）
- 使用 `LaunchedEffect` 在 UI 层安全执行副作用

---

## 学习来源

本项目参考以下教程完成并且更新到了比较新的相关依赖库：

- [How to Make a Clean Architecture Note App (MVVM / CRUD / Jetpack Compose) - Android Studio Tutorial](https://www.youtube.com/watch?v=8YPXv7xKh2w&t=8478s)

---

## 说明

该项目主要用于学习：

- Jetpack Compose UI 构建
- 单向数据流（UDF）
- 协程与 Flow 基本使用
- Android 分层架构设计
