<h1>Java Concurrency</h1>

This project shows usage of various features related to Java concurrency.

<h3>Features:</h3>

<h4>1. Thread order</h4>
- Basic thread synchronization with join()

<h4>2. Multithreaded counters</h4>

Testing various methods of synchronization based on incrementing a variable from multiple threads.

- AtomicCounter
- SynchronizedBlockCounter
- SynchronizedMethodCounter
- UnsafeCounter
- VolatileCounter

<h5>AtomicInteger</h5>
<i>
An int value that may be updated atomically.
</i>

<h5>Synchronized method/block</h5>
<i>
A Java synchronized block marks a method or a block of code as synchronized. Java synchronized blocks can be used to avoid race conditions.
</i>

<h5>Volatile keyword</h5>
<i>
The Java volatile keyword is used to mark a Java variable as "being stored in main memory". More precisely that means, that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and that every write to a volatile variable will be written to main memory, and not just to the CPU cache.
</i>

<h4>3. Locks</h4>

<h5>ReentrantLock</h5>
<i>
A reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit monitor lock accessed using synchronized methods and statements, but with extended capabilities.
</i><br/><br/>
<i>
A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it. A thread invoking lock will return, successfully acquiring the lock, when the lock is not owned by another thread. The method will return immediately if the current thread already owns the lock. This can be checked using methods isHeldByCurrentThread(), and getHoldCount().
</i>

<h4>4. CountDownLatch, CyclicBarrier, Semaphore</h4>

<h5>CountDownLatch</h5>

<i>
A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
A CountDownLatch is initialized with a given count. The await methods block until the current count reaches zero due to invocations of the countDown() method, after which all waiting threads are released and any subsequent invocations of await return immediately. This is a one-shot phenomenon -- the count cannot be reset. If you need a version that resets the count, consider using a CyclicBarrier.
</i>

<h5>CyclicBarrier</h5>

<i>
A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point. CyclicBarriers are useful in programs involving a fixed sized party of threads that must occasionally wait for each other. The barrier is called cyclic because it can be re-used after the waiting threads are released.
</i><br/><br/>
<i>
A CyclicBarrier supports an optional Runnable command that is run once per barrier point, after the last thread in the party arrives, but before any threads are released. This barrier action is useful for updating shared-state before any of the parties continue.
</i>

<h5>Semaphore</h5>

<i>
A counting semaphore. Conceptually, a semaphore maintains a set of permits. Each acquire() blocks if necessary until a permit is available, and then takes it. Each release() adds a permit, potentially releasing a blocking acquirer. However, no actual permit objects are used; the Semaphore just keeps a count of the number available and acts accordingly.
</i><br/><br/>
<i>
Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource. For example, here is a class that uses a semaphore to control access to a pool of items.
</i>

<h4>5. FutureTask, ScheduledExecutorService, ScheduledFuture</h4>

<h5>FutureTask</h5>
<i>
A cancellable asynchronous computation. This class provides a base implementation of Future, with methods to start and cancel a computation, query to see if the computation is complete, and retrieve the result of the computation.
</i><br/><br/>
<i>
The result can only be retrieved when the computation has completed; the get methods will block if the computation has not yet completed. Once the computation has completed, the computation cannot be restarted or cancelled (unless the computation is invoked using runAndReset()).
</i>

<h5>ScheduledExecutorService</h5>
<i>
An ExecutorService that can schedule commands to run after a given delay, or to execute periodically.
The schedule methods create tasks with various delays and return a task object that can be used to cancel or check execution. The scheduleAtFixedRate and scheduleWithFixedDelay methods create and execute tasks that run periodically until cancelled.
</i><br/><br/>
<i>
Commands submitted using the Executor.execute(java.lang.Runnable) and ExecutorService submit methods are scheduled with a requested delay of zero. Zero and negative delays (but not periods) are also allowed in schedule methods, and are treated as requests for immediate execution.
</i><br/><br/>
<i>
All schedule methods accept relative delays and periods as arguments, not absolute times or dates
</i>

<h5>ScheduledFuture</h5>
<i>
A delayed result-bearing action that can be cancelled. Usually a scheduled future is the result of scheduling a task with a ScheduledExecutorService.
</i>

<h4>6. Blocking and non-blocking mechanisms</h4>

- Blocking queue
- Deadlock example
- Forkjoin
- Non-blocking queue

<h5>ArrayBlockingQueue</h5>
<i>
A bounded blocking queue backed by an array. 
Attempts to put an element into a full queue will result in the operation blocking; attempts to take an element from an empty queue will similarly block.
</i>

<h5>ConcurrentLinkedQueue</h5>
<i>
An unbounded thread-safe queue based on linked nodes.
This class does not permit the use of null elements.
This implementation employs an efficient "wait-free" algorithm.
</i><br/><br/>
<i>
Iterators are weakly consistent, returning elements reflecting the state of the queue at some point at or since the creation of the iterator. They do not throw ConcurrentModificationException, and may proceed concurrently with other operations. Elements contained in the queue since the creation of the iterator will be returned exactly once.
</i>

<h5>ForkJoinPool</h5>
<i>
The ForkJoinPool was added to Java in Java 7. The ForkJoinPool is similar to the Java ExecutorService but with one difference. The ForkJoinPool makes it easy for tasks to split their work up into smaller tasks which are then submitted to the ForkJoinPool too. Tasks can keep splitting their work into smaller subtasks for as long as it makes to split up the task.
</i>

<h5>Deadlock</h5>
<i>
A deadlock is when two or more threads are blocked waiting to obtain locks that some of the other threads in the deadlock are holding. Deadlock can occur when multiple threads need the same locks, at the same time, but obtain them in different order.
</i><br/><br/>
<i>
For instance, if thread 1 locks A, and tries to lock B, and thread 2 has already locked B, and tries to lock A, a deadlock arises. Thread 1 can never get B, and thread 2 can never get A. In addition, neither of them will ever know. They will remain blocked on each their object, A and B, forever. This situation is a deadlock.
</i>


** Descriptions taken from Java manual or from jenkov.com