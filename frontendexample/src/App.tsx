import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const getText = async () => {
    try {
      const text = await fetch("http://localhost:8080/");
      if (text.status !== 200) {
        console.error("Error fetching data");
        return;
      }
      setText(await text.text());
    } catch (e) {
      console.error("Could not connect to server");
    }
  }

  const [text, setText] = useState("No data fetched yet!");

  useEffect(() => { getText(); }, []);
  return (
    <>
      <p>Data from Springboot: <strong>{text}</strong></p>
    </>
  )
}

export default App
