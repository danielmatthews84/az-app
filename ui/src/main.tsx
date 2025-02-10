import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    {/*  Could provide an ErrorBoundary component here to ensure a fallback display in case of an error */}
    <App />
  </StrictMode>,
)

// Should include a router e.g. react-router-dom to handle page navigation.
