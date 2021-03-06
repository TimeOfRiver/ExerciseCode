package effectiveJava.chap9;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/23
 */
public class ExceptionOne {
    // 只针对异常的情况才使用异常，异常应该只用于异常的情况下，它们永远不应该用于正常的控制流

    // 对可恢复的情况使用受检异常，对编程错误使用运行时异常

    // 避免不必要地使用受检的异常

    // 优先使用标准的异常

    // 抛出与抽象相对应的异常

    // 每个方法抛出的异常都要有文档：始终要单独地声明受检的异常，并且利用Javadoc的@throws标记，准确地记录下抛出每个异常的条件;

    // 使用Javadoc的@throws标签记录下一个方法可能抛出的每个未受检异常，但是不要使用throws关键字将未受检的异常包含在方法的声明中

    // 如果一个类中的许多方法出于同样的原因而抛出同一个异常，在该类的文档注释中对这个异常建立文档，这是可以接受的，而不是为每个方法单独建立文档

    // 在细节消息中包含能捕获失败的信息：为了捕获失败，异常的细节信息应该包含所有"对该异常有贡献"的参数和域的值

    // 努力使失败保持原子性

    // 不要忽略异常,例如下列代码，即使不需要处理异常，也必须添加一条说明来记录为什么可以忽略这个异常
    //try {
    //
    //} catch(Exception e) {
    //
    //}
}
