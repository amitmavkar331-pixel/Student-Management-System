import { useEffect, useState } from 'react'

import './App.css'
import axios from 'axios';

function App() {
   const [students, setStudents] = useState([]);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    const res = await axios.get("http://localhost:8080/students");
    setStudents(res.data);
  };

  const addStudent = async () => {
    await axios.post("http://localhost:8080/students", { name, email });
    setName("");
    setEmail("");
    fetchStudents();
  };

  const deleteStudent = async (id) => {
    await axios.delete(`http://localhost:8080/students/${id}`);
    fetchStudents();
  };




  return (
     <div style={{ padding: "20px" }}>
      <h2>Student Management</h2>

      <input
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <br /><br />

      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br /><br />

      <button onClick={addStudent}>Add Student</button>

      <hr />

      <ul>
        {students.map((s) => (
          <li key={s.id}>
            {s.name} - {s.email}
            <button onClick={() => deleteStudent(s.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>

    
      
    
  )
}

export default App
